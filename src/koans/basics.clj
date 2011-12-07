(meditations
 "fail is a goal that fails. A goal is some statement we would like to
satisfy. run* lets us to specify a series of goals we would like to
satisfy. run* always returns a sequence. The empty sequence means that
there is no value q such that q can satisfy the goals. This makes sense,
fail can never succeed."
 (= (run* [q] fail)
    __)
 
 "succeed is a goal that succeeds. Remember run* always returns a sequence.
run* found one solution for q, _.0. This means that any value q is
satisfactory. This makes sense, succeed always succeeds"
 (= (run* [q] __)
    '(_.0))

 "The goals contained in run* form a logical conjunction (AND). For
example here we want some goal A that succeeds and some goal B that
succeeds such that it does not matter what value q is."
 (= (run* [q] __ ___)
    '(_.0))

 "We know of two goals, succeed and fail. Since run* is like AND, if
any goal fails, the entire program fails."
 (= (run* [q] succeed fail)
    __)

 "Here is a new goal, ==. It means unify. It takes two things and tries
to make them equal. What value can q take on that will satisfy this
program?"
 (= (run* [q] (== q true))
    '(__))

 "The order of the terms you pass to unify do not matter."
 (= (run* [q] (== true q))
    '(__))

 "Is there any value for q that can satisfy this program?"
 (= (run* [q]
      (== q true)
      (== false q))
    __)

 "We use q to get results back. We can give this output variable
any name we want."
 (= (run* [x]
      (== x true))
    '(__))

 "Often we want to write more complex goals - being able to introduce
logic variables beyond the output variable is quite useful! We can do this
with fresh. Fresh introduce new lexically scoped logic variables.
Like run*, the goals in fresh form a logical conjunction."
 (= (run* [q]
      (fresh [x y]
        (== x 1)
        (== y 2)
        (== q [x y])))
    '(__))

  "The order of goals does not matter."
 (= (run* [q]
      (fresh [x y]
        (== q [x y])
        (== x 1)
        (== y 2)))
    '(__))

 "Sometimes we want to express logic disjunction (OR). For that we need
to use conde. If we use conde we may get back multiple answers! There
is no guarantee about the answer order - so don't follow this example."
 (let [ans (run* [q]
             (conde
               [(== q 'logic)]
               [(== q 'is)]
               [(== q 'cool)]))]
   (= ans '(logic __ cool)))

 "Each branch of a conde is an AND conjunction. If one cannot be satisfied
that's ok, the others will be tried."
 (let [ans (run* [q]
             (conde
               [(== q 'logic)]
               [fail (== q 'is)]
               [(== q 'cool)]))]
   (= ans __))

 "Does this return any answers?"
 (= (run* [q]
       (conde
         [(== q 'an-answer)]
         [(== q 'another-answer)])
       fail)
     __)

 "What answers does this return?"
 (= (run* [q]
       (conde
         [(== q 'an-answer) fail]
         [(== q 'another-answer)])
       succeed)
     __)

 "How about this one?"
 (= (run* [q]
       (fresh [x]
         (conde
           [(== q 'an-answer) (== x 1)]
           [(== q 'another-answer) (== x 2)])
         (== x 1)))
     __)
 )