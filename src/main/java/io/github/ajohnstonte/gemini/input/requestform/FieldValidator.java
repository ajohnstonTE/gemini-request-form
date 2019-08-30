package io.github.ajohnstonte.gemini.input.requestform;

import com.techempower.gemini.input.Input;
import com.techempower.gemini.input.validator.Validator;

/**
 * A validator to be applied for a form field. This field does not directly
 * extend validator as it is *not* intended to be added directly. Instead, the
 * field it is added to should provide a reference to itself, then convert it
 * to a validator. This is for the purpose of chain calls.
 *
 * @author ajohnston
 */
public abstract class FieldValidator<T>
{
  //
  // Variables.
  //

  private IField<T> field;

  /**
   * Constructor.
   */
  public FieldValidator()
  {
  }

  /**
   * Should be called by the field when adding it. This is to allow field
   * validators to be added during definition chains.
   *
   * @param field - the field to associate with
   */
  protected FieldValidator<T> setField(IField<T> field)
  {
    this.field = field;
    return this;
  }
  
  protected IField<T> getField()
  {
    return field;
  }

  protected T getValue(Input input)
  {
    return getField().getValueFrom(input);
  }

  protected Validator asValidator()
  {
    return this::process;
  }

  /**
   * Performs a validation of the element.  Returns null if there is no
   * validation error; a non-null String message otherwise.
   */
  protected abstract void process(final Input input);

  /**
   * Gets the Element's name.
   */
  public String getElementName()
  {
    return getField().getName();
  }
}
