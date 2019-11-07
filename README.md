# composite-java

There are two types of objects
1) Type
2) Composite (inherited from Type)

A type can hold just value or key-value where value can be of any primitive data type or of Composite type.
A type cannot have subtypes

Eg:
`a = 10` can be represented as `new Type(10)`

A composite will always have subtypes which are of type Type

Eg:
`a = [10]`
can be represented as
`Composite c = new Composite().add(new Type(0, 10))`

After above code execution, `c.subtypes` will result into `[Type(0,10)]`

Note that first parameter in Type constructor indicates the index of the value where it is present in the composite

More composite examples
## Array
```
a = ["Apple", "Orange", Kiwi"]
```
will be represented as
```
Composite c = new Composite().
                		add(new Type(0, "Apple")).
                		add(new Type(1, "Orange")).
                		add(new Type(2, "Kiwi"));
```

## JSON / Hash / Map / Associative Array (whatever it's called in your language :))
```
h = {"name":"John", age: 10}
```
will be represented as
```
Composite c = new Composite().
                    add(new Type("name", "John")).
                    add(new Type("age", 10));
```
### Complex hash
```
h = {
  "name":"John",
  "phones":[9876543210, 9999999999],
  "address:{
    "home":"Mumbai",
    "work":"Pune"
  }
}
```
will be represented as
```
Composite c = new Composite().
                    add(new Type("name", "John")).
                    add(new Type("phones", new Composite().
                                                 add(new Type(0, 9876543210)).
                                                 add(new Type(1, 9999999999))).
                    add(new Type("address", new Composite().
                                                  add(new Type("home","Mumbai")).
                                                  add(new Type("work","Pune"))
                 )));
```
