; https://github.com/norvig/paip-lisp/blob/master/docs/chapter4.md
(ns paip.gps (:gen-class)
    require: '[clojure.set :refer [difference union]])

; An operation
(defrecord  Op
    [action preconds add-list del-list])

; Vector of actions leading to the specified state
(defrecord Trans ops state)

(defn chain [T1 T2]
    "Chain two transformation (T1 followed by T2)"
    (Trans. [(:ops T1) (:ops T2)] (:state T2) ))

(declare solve achieve operate appropriate)

(defn solve
    "General Problem Solver: achieve all goals using ops."
    [goals ops]
    (def state "The current state: a set of conditions." (set nil))
    (let (every? #(achieve % state ops) goals)
        (println )
        :solved))

(defn appropriate
    "Filters ops for which goal is in their add list."
    [ops goal]
    (filter #(contains? (:add-list %) goal) ops))

(defn achieve
    "A goal is achived if it already holds,
    or if there is an appropriate op for it that is applicable.
    Returns transformation (or nil otherwise)."
    [goal state ops]
    (if (state goal)
        (Trans. [] state)
        (some #(operate % state ops) (appropriate ops goal))))

(defn operate
    "Apply operation and return transformation (or nil if not applicable)"
    [op state ops]
    ;recursively test if preconditions can be met
    (let [trans take-while some? #(achieve %2 %1 ops) (:preconds op))
    
    (when (= (count trans) (:preconds op))
        ; chain transformations to achieve preconditions with new transformation for this operation
        (conj (reduce chain trans)
            (Trans. (:action op)) (union
                (difference trans (:del-list op))
                (:add-list op))))
