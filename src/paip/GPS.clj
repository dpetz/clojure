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

(declare achieved? apply-op appropriate?)

(defn solve 
    "General Problem Solver: achieve all goals using ops."
    [goals ops]
    (def state "The current state: a set of conditions." (set nil))
    (when (every? #(achieved? % state ops) goals) :solved))

(defn appropriate
    "Filters ops that appropriate to a goal, i.e that it is in their add list."
    [ops goal]
    (filter #(contains? (:add-list %) goal) ops))

(defn achieved
    "A goal is achived if it already holds,
    or if there is an appropriate op for it that is applicable.
    Evalates to updated state or nil otherwise."
    [goal state ops]
    ;(print 'achieved? goal "in state" state "via ops" ops)
    (if (or (nil? state) (state goal)
        (state)
        (some
            #(apply-op % state ops))
            (appropriate ops goal))))

;;(GPS #{:drive-son-to-school} ops)

(require '[clojure.set :refer [difference union]])

(defn apply-op
    "Print a message and update state if op is applicable."
    [op state ops]
    ;(print "may apply:" op state ops)
    (let [ (reduce
            #(let [a (achieved? %2 %1 ops)]
                (if (nil? a) (:reduced nil) (a)
            (state)
            (:preconds op))


        (every?  )
        (do
            ((print "Executing" (:action op))
            (union
                (difference state (:del-list op))
                (:add-list op))))))
