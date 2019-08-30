package io.github.ajohnstonTE.gemini.input.requestform;

import com.techempower.gemini.input.Input;
import io.github.ajohnstonTE.gemini.input.Values;
import com.techempower.gemini.input.validator.Validator;

import java.util.function.BiConsumer;
import java.util.function.Function;

public abstract class ExtendableField<T, S extends ExtendableField<T, S>>
  extends Field<T>
{

  public ExtendableField(IRequestForm contract, String name, Class<T> type)
  {
    super(contract, name, type);
  }

  @Override
  public S addValidator(Validator validator)
  {
    super.addValidator(validator);
    return self();
  }

  @Override
  public S addFieldValidator(FieldValidator<T> fieldValidator)
  {
    super.addFieldValidator(fieldValidator);
    return self();
  }

  @Override
  public S addFieldValidator(BiConsumer<IField<T>, Input> fieldValidator)
  {
    super.addFieldValidator(fieldValidator);
    return self();
  }

  @Override
  public S setRequired(boolean required)
  {
    super.setRequired(required);
    return self();
  }

  @Override
  public S setValueAccess(Function<ValueAccess, T> valueAccess)
  {
    super.setValueAccess(valueAccess);
    return self();
  }

  @Override
  public S setDefaultOnProcess(T defaultOnProcess)
  {
    super.setDefaultOnProcess(defaultOnProcess);
    return self();
  }

  @Override
  public S setValue(T value)
  {
    super.setValue(value);
    return self();
  }

  @Override
  public S setValueAccess(Function<ValueAccess, T> valueAccess, T defaultValue)
  {
    super.setValueAccess(valueAccess, defaultValue);
    return self();
  }

  @Override
  public S setValueToDefault()
  {
    super.setValueToDefault();
    return self();
  }

  @Override
  public S setFrom(Values values)
  {
    super.setFrom(values);
    return self();
  }

  @SuppressWarnings("unchecked")
  protected S self()
  {
    return (S)this;
  }
}
