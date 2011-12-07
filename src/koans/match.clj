(defne geto [k s o]
  ([_ [k o . _] _])
  ([_ [_ . r] _] (geto k r o)))

(meditations
 "The geto goal uses the defne macro which adds pattern matching sugar. What
does geto do?"
 (= (run* [q]
      (geto [[:foo 1] [:bar 2]] :bar q))
    '(__))
 )