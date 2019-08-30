package io.github.ajohnstonte.gemini.input.requestform;

import com.techempower.gemini.input.validator.LengthValidator;
import com.techempower.gemini.input.validator.Validator;

import java.util.List;

/**
 * A field that supports text input. Provides convenience methods for specifying the min/max lengths values allowable.
 * If using the forms JSP tags, these are translated into the minlength/maxlength attributes.
 *
 * @author ajohnston
 */
public class TextField<T>
    extends ExtendableField<T, TextField<T>>
{
  private Integer minLength;
  private Integer maxLength;
  
  public TextField(IRequestForm contract, String name, Class<T> type)
  {
    super(contract, name, type);
  }
  
  public Integer getMinLength()
  {
    return minLength;
  }
  
  public TextField<T> setMinLength(Integer minLength)
  {
    this.minLength = minLength;
    return this;
  }
  
  public Integer getMaxLength()
  {
    return maxLength;
  }
  
  public TextField<T> setMaxLength(Integer maxLength)
  {
    this.maxLength = maxLength;
    return this;
  }
  
  @Override
  public List<Validator> getStandardValidators()
  {
    List<Validator> validators = super.getStandardValidators();
    Integer minLength = getMinLength();
    Integer maxLength = getMaxLength();
    if (minLength != null || maxLength != null)
    {
      int minimumLength = minLength != null ? minLength : Integer.MIN_VALUE;
      int maximumLength = maxLength != null ? maxLength : Integer.MIN_VALUE;
      validators.add(new LengthValidator(getName(), minimumLength, maximumLength, !isRequired()));
    }
    return validators;
  }
}
