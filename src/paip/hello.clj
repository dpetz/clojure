(​defn​ greeting
    ​ 	  ​"Returns a greeting of the form 'Hello, username.'"​
    ​ 	  [username]
    ​ 	  (str ​"Hello, "​ username))


;; dec Returns a number one less than num.

(defn factorial [n]
    (if (= n 0)
        1
        (* n (factorial (dec n)))))

(factorial 4)

(require '[clojure.repl :refer :all])
(doc map)
(find-doc "trim")