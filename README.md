### How to Migrate from Contracts -> RequestForms

- `Contract` -> `ResponseForm`
- For fields other than `ContractWholeNumberField` and `ContractDoubleField`, just remove "Contract" from the beginning.
- For `ContractWholeNumberField` and `ContractDoubleField`, switch to `NumberField`.
- Pretty much all field definitions can be done in a chain. All set-/add- methods return the field again.
- The field's type must now be passed in as the last parameter to the constructor
  - eg: `new Field<>(form, "name", Integer.class)`
- All the basic value accessors are automatically applied.
  - Specifically, this means any method reference-able stuff. `Boolean` defaults to `getBooleanLenient`.
- `setDefaultValue` -> `setDefaultOnProcess`
  - The name is worse, but also less misleading. I'll probably just go with `setDefault` at some point. Maybe.
- `setMultivalued` -> (now only in `SelectField`) `setAllowMultipleValues`