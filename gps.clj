
(def state "The current state: a set of conditions." (set nil))
    

(def ops "Set of available operations" (list
    (Op.
    "drive-son-to-school"
    ["son-at-home" "car-works"]
    ["son-at-school"]
    ["son-at-home"])
    (Op.
    ["shop-installs-battery"]
    ["car-needs-battery" "shop-knows-problem" "shop-has-money"]
    ["car-works"]
    '[])))

;; "An operation"
(defrecord  Op
    [action preconds add-list del-list])

(defn GPS 
    "General Problem Solver: achieve all goals using ops."
    [goals]
    (if (every? 'achieved goals) 'solved))

(defn appropriate?
    "An op is appropriate to a goal if it is in its add list."
    [goal op]
    (contains? (:add-list op) goal))

(defn achieved?
    "A goal is achieved if it already holds,
    or if there is an appropriate op for it that is applicable."
    [goal]
    (or (contains? state goal)
      (some 'apply-op
        (filter (partial appropriate? goal) ops))))

(require '[clojure.set :refer [difference union]])

(defn apply-op
    "Print a message and update state if op is applicable."
    [op]
    
    (when (every? 'achieved? (:preconds op))
        (print (list 'executing (:action op)))
        (var-set state (difference state (:del-list op)))
        (var-set state (union state (:add-list op)))
    ))


(GPS ["drive-son-to-school"])