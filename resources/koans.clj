;; this file should contain a vector of 2-vectors; each 2-vector must
;; contain a koan name and a map of koan answers, in that order.

[["basics" {"__" [()
                  succeed
                  succeed
                  ()
                  true
                  true
                  ()
                  true
                  [1 2]
                  [1 2]
                  is
                  '(logic cool)]
            "___" [succeed]}]
 ["genealogy" {"__" [son
                     parent
                     (conde
                       [(== x 'Jenny) (== y 'guitar)])
                     (grandparent y x)
                     ]}]

 ["goals" {"__" [a
                 'a
                 (b c)
                 a]}]
 ]
