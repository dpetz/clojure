;; https://github.com/norvig/paip-lisp/blob/master/docs/chapter4.md
(ns paip.gps
    (:gen-class))
;; "An operation"
(defrecord  Op
    [action preconds add-list del-list])
    
(def ops "Set of available operations" (list
    (Op.
        :drive-son-to-school
        [:son-at-home :car-works]
        [:son-at-school]
        [:son-at-home])
    (Op.
        :shop-installs-battery
        [:car-needs-battery :shop-knows-problem :shop-has-money]
        [:car-works]
        [])
    (Op.
        :just-do-it
        []
        [:drive-son-to-school]
        [])))

(declare solve achieve operate appropriate)

(defn solve
    "General Problem Solver: achieve all goals using ops."
    [goals ops]
    (def state "The current state: a set of conditions." (set nil))
    (when (every? #(achieve % state ops) goals) :solved))

(defn appropriate
    "Filters ops for which goalis in their add list."
    [ops goal]
    (filter #(contains? (:add-list %) goal) ops))

(defn achieve
    "A goal is achived if it already holds,
    or if there is an appropriate op for it that is applicable.
    Evalates to (updated) state or nil otherwise."
    [goal state ops]
    ;(print '"Achieved" goal "in" state)
    (if (or (nil? state) (state goal))
        state
        (some
            #(operate % state ops)
            (appropriate ops goal))))

;;(GPS #{:drive-son-to-school} ops)

(require '[clojure.set :refer [difference union]])

(defn operate
    "Update state and print a message if op is applicable.
    Evaluates to updated state or nil otheriwse."
    [op state ops]
    ;(print "may apply:" op state ops)
    (when-let [state-new
        (reduce #(achieve %2 %1 ops)
        state (:preconds op))]

        (print "Executing" (:action op))
        (union
            (difference state-new (:del-list op))
            (:add-list op))))
