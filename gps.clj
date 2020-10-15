
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

(declare achieved apply-op appropriate?)

(defn GPS 
    "General Problem Solver: achieve all goals using ops."
    [goals ops]
    (def state "The current state: a set of conditions." (set nil))
    (if (every? #(achieved? % state ops) goals) :solved))

(defn appropriate?
    "An op is appropriate to a goal if it is in its add list."
    [op goal]
    (contains? (:add-list op) goal))


(defn achieved?
    "A goal is achieved if it already holds,
    or if there is an appropriate op for it that is applicable."
    [goal state ops]
    (print 'achieved? goal "in state" state "via ops" ops)
    (or (state goal)
      (some #(apply-op % state ops)
        (filter #(appropriate? % goal) ops))))

(GPS #{:drive-son-to-school} ops)

(require '[clojure.set :refer [difference union]])

(defn apply-op
    "Print a message and update state if op is applicable."
    [op state ops]
    
    (if (every? #(achieved? % state ops) (:preconds op))
        ((print (list 'executing (:action op)))
        (union
            (difference state (:del-list op))
            (:add-list op)))
        ('state)))

