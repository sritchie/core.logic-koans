(meditations
 "Note that sequences and vectors can be unified. What value will a and b take?"
 (= (run* [q]
      (fresh [a b x y]
        (== x [1 a])
        (== y `(,b 2))
        (== q [a b])))
    '([__ ___]))

 "We can unify persistent maps. Note you should not have logic vars
in the keys of a map. What value will q take?"
 (= (run* [q]
      (fresh [x]
        (== x {:foo 1})
        (== x {:foo q})))
    '(__))
 )