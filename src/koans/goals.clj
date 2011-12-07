(meditations
 "The firsto relation works like first. Many interesting goals have 'output'
variables. What do you think q will be in this case?"
 (= (run* [q]
      (== s '(a b c))
      (firsto s q))
    '(__))

 "Relations are a bit more general than functions. We can infer inputs if we
have the output. For example firsto will give an answer that represents *any*
list that starts with the symbol a."
 (= (run* [q]
      (firsto q 'a))
    [(lcons __ '_.0)])

 "It's perhaps easier to see this in action with conso. What value of q will
make this relation be true?"
 (= (run* [q]
      (fresh [a d]
       (conso 'a q '(a b c))))
    '(__))

 "What value of q will make this relation be true?"
 (= (run* [q]
      (fresh [a d]
       (conso  q '(b c) '(a b c))))
    '(__))
 )