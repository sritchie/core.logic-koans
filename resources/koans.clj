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
                  '(logic cool)
                  ()
                  '(another-answer)
                  '(an-answer)
                  ]
            "___" [succeed]}]
 
 ["genealogy" {"__" [son
                     parent
                     (conde
                       [(== x 'Jenny) (== y 'guitar)])
                     (grandparent y x)
                     ]}]

 ["goals" {"__" [a
                 y
                 'a
                 (b c)
                 a
                 '_.0
                 '(cat dog bird)
                 '(dog bird)
                 (lcons 'cat '_.0)
                 (llist '_.0 'cat '_.1)
                 ]
           "___" ['_.1]}]
 ]
