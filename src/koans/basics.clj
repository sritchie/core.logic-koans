(meditations
 "fail is a goal that fails. a goal is some statement we would like to
satisfy. run* lets us to specify a series of goals we would like to
satisfy. run* always returns a sequence. the empty sequence means that
there no value q such that q can satisfy the goals. this makes sense,
fail can never succeed."
 (= (run* [q] fail)
    __)
 
 "succeed is a goal that succeeds. remember run* always returns a sequence.
run* found one solution for q, _.0. this means that any value q is
satisfactory. this makes sense, succeed always succeeds"
 (= (run* [q] __)
    '(_.0))

 "the goals contained in run* form a logical conjunction (AND). for
example here we want some goal A that succeeds and some goal B that
succeeds such that it does not matter what value q is."
 (= (run* [q] __ ___)
    '(_.0))

 "we know of two goals, succeed and fail. since run* is like AND if
any goal fails, the entire program fails."
 (= (run* [q] succeed fail)
    __)

 "here is a new goal, ==. it means unify. it takes two things and tries
to make them equal. what value can q take on that will satisfy this
program?"
 (= (run* [q] (== q true))
    '(__))

 "the order of the terms you pass to unify do not matter."
 (= (run* [q] (== true q))
    '(__))

 "is there any value for q that can satisfy this program?"
 (= (run* [q]
      (== q true)
      (== false q))
    __)

 "we use q to get results back. we can give this output variable
any name we want."
 (= (run* [x]
      (== x true))
    '(__))

 "often we want to write more complex goals - being able to introduce
logic variables beyond the output variable is quite useful! we can do this
with fresh. fresh introduce new lexically scoped logic variables.
like run*, the goals in fresh form a logical conjunction."
 (= (run* [q]
      (fresh [x y]
        (== x 1)
        (== y 2)
        (== q [x y])))
    '(__))

  "the order of goals does not matter."
 (= (run* [q]
      (fresh [x y]
        (== q [x y])
        (== x 1)
        (== y 2)))
    '(__))

 "sometimes we want to express logic disjunction (OR). for that we need
to use conde. if we use conde we may get back multiple answers! there
is no guarantee about the answer order - so don't follow this example."
 (let [ans (run* [q]
             (conde
               [(== q 'logic)]
               [(== q 'is)]
               [(== q 'cool)]))]
   (= ans '(logic __ cool)))

 "each branch of a conde is an AND conjunction. If one cannot be satisfied
that's ok, the others will be tried."
 (let [ans (run* [q]
             (conde
               [(== q 'logic)]
               [fail (== q 'is)]
               [(== q 'cool)]))]
   (= ans __))
 )