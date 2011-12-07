(meditations
 "The firsto relation works similarly to first first. Many interesting goals have 'output'
variables. What do you think q will be in this case?"
 (= (run* [q]
      (fresh [s]
        (== s '(a b c))
        (firsto s q)))
    '(__))

 "In Clojure it is impossible to make a sequence that ends with non-seq
tail. core.logic allows seqs that have logic vars as their tail. This lets
us do some interesting things. We use lfirst and lnext to pull apart lcons."
 (let [x (lvar 'x)
       y (lvar 'y)]
   (= (lnext (lcons x y))
      __))

 "Relations are a bit more general than functions. We can infer inputs if we
have the output. For example firsto will give an answer that represents *any*
list that starts with the symbol a."
 (= (run* [q]
      (firsto q 'a))
    [(lcons __ '_.0)])

 "It's perhaps easier to see this in action with conso. What value of q will
satisfy this relation"
 (= (run* [q]
      (conso 'a q '(a b c)))
    '(__))

 "What value of q will satisfy the relation?"
 (= (run* [q]
      (conso q '(b c) '(a b c)))
    '(__))

 "What will the output value of conso be if we provide only logic vars?"
 (= (run* [q]
      (fresh [a d]
        (conso a d q)))
    [(lcons __ ___)])

 "membero is an interesting relation. it checks for membership. What are
values of q that satisfy this relation?"
 (= (run* [q]
       (membero q '(cat dog bird)))
     __)

 "How about now?"
 (= (run* [q]
       (membero q '(cat dog bird))
       (membero q '(dog bird zebra)))
    __)

 "Here we give run a specific number to control how many answers we get. Think
carefully. Is there only one list in the universe that satisfies this relation?
Are there infinitely many?"
 (= (run 1 [q]
       (membero 'cat q))
    [__])

 "What is the second answer? This one is quite hard. It's ok to cheat on this one :)
What does the answer mean? Does it seem like it might be dangerous to use run* on this
particular use of membero?"
 (= (second
     (run 2 [q]
       (membero 'cat q)))
    __)
 )