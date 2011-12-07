(defn male [x]
  (conde
    [(== x 'John)]
    [(== x 'Bobby)]
    [(== x 'George)]
    [(== x 'Harold)]
    [(== x 'Thomas)]))

(defn female [x]
  (conde
    [(== x 'Mary)]
    [(== x 'Jenny)]
    [(== x 'Martha)]))

(defn parent [x y]
  (conde
    [(== x 'Bobby) (conde
                     [(== y 'John)]
                     [(== y 'Mary)])]
    [(== x 'Jenny) (conde
                     [(== y 'George)]
                     [(== y 'Martha)])]
    [(== x 'Harold) (conde
                      [(== y 'Jenny)]
                      [(== y 'Thomas)])]))

(defn grandparent [x y]
  (fresh [z]
    (parent x z)
    (parent z y)))

(defn child [x y]
  (parent y x))

(defn daughter [x y]
  (all
   (female y)
   (child x y)))

(defn son [x y]
  (all
   (male y)
   (child x y)))

(meditations
 "What goal(s) defines Johns relation to Bobby?"
 (= (run* [q]
      (__ 'John q))
    '(Bobby))

 "What goal satisfies this relation?"
 (= (run* [q]
      (__ 'Bobby q))
    '(John Mary))

 "Write a goal that makes this program satisfiable."
 (letfn [(plays [x y]
           __)]
  (= (run* [q]
       (daughter 'Martha q)
       (plays q 'guitar))
     '(Jenny)))

 "Write the grandchild relation."
 (letfn [(grandchild [x y]
           __)]
  (= (run* [q]
       (grandchild q 'Harold))
     '(George Martha)))
 )