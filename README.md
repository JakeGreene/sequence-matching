Sequence Matching
================
I feel it is unfair that List gets the useful :: builder and matcher but other sequences do not. This project is an attempt to correct that.

Building Sequences
-----------------
Much like the sequence `::` operator, all sequences now have the `:+:` operator.

`1 :+: 2 :+: SNil` will produce `List(1, 2)` as if using `1 :: 2 :: Nil`. The difference is, this can be used by any `Seq`.

```
1 :+: 2 :+: Queue(3) //Will produce Queue(1, 2, 3)
1 :+: 2 :+: Vector(3) //Will produce Vector(1, 2, 3)
```

Pattern Matching
----------------
List has the very handy pattern matching tool `::`

```
List(1, 2, 3) match {
  case head :: tail => println(head)
}
``` 

The operator `:+:` has been added to give this same power to all sequences:

```
Queue(1, 2, 3) match {
  case head :+: tail => println(head)
}
```
