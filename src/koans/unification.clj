(meditations
 "What value will a and b take?"
 (= (run* [q]
      (fresh [a b x y]
        (== x [1 a])
        (== y [b 2])
        (== q [a b])))
    '([1 2]))
 )