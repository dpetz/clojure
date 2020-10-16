

# Getting Started

Log of steps and useful links:

- [How to][blog] get started with [Clojure]
- _JDK 8_ or _JDK 11_ are recommended:
```
  brew install openjdk@11
  ls -l `which java`
  export JAVA_HOME=/usr/local/opt/openjdk@11
```
- Install [Leiningen]

- [VS Code] extensions:
  - [Clojure][lisin] for `lein repl` integration works well
  - tried [Clojure Code][norton] (for debugging) but no longer maintained and not working for JDK 11
  - tried [Calva] too cluttered and issues connecting `repl`

- Create project scaffold ([blog](http://alexott.net/en/clojure/ClojureLein.html), [tutorial]())https://github.com/technomancy/leiningen/blob/stable/doc/TUTORIAL.md. Look at it via `tree`
  ```
  brew install tree
  tree -F -a --dirsfirst paip/
  ```

- Push to a new GitHub repo:
```
git remote set-url origin https://github.com/dpetz/paip.git
git branch -M main
git push -u origin main
```

- Getting started with Clojure [syntax] and [repl] 

- [Paradigms of Artificial Intelligence Programming (Norvig, 1991)](https://www.amazon.com/Paradigms-Artificial-Intelligence-Programming-Studies/dp/1558601910) has a [free online repo](https://github.com/norvig/paip-lisp) of book content and code.

- [Programming Clojure (Miller, 2018)](https://www.amazon.com/Programming-Clojure-Pragmatic-Programmers-Miller/dp/1680502468) best book for experienced programmers.


Useful `lein` commands:
```
lein compile :all
```

Usefull `repl` commands:
```
(in-ns 'paip.gps-test)
(clojure.core/refer 'clojure.core)
(clojure.core/refer 'clojure.repl)
```
`require` [preferred](https://stackoverflow.com/a/16429572) over `use` outside the `repl`. 
repeat `(use 'paip.gps :reload)` whenever a definition has changed.


[Calva]: https://marketplace.visualstudio.com/items?itemName=betterthantomorrow.calva
[norton]: https://marketplace.visualstudio.com/items?itemName=jamesnorton.continuum
[lisin]: https://marketplace.visualstudio.com/items?itemName=avli.clojure
[Clojure]: https://clojure.org/
[syntax]: https://clojure.org/guides/learn/syntax
[repl]: https://clojure.org/guides/repl/basic_usage
[VS Code]: https://code.visualstudio.com/
[blog]: https://spin.atomicobject.com/2017/06/22/clojure-development-with-visual-studio-code/
[Leiningen]: https://leiningen.org/#install
[extension]: https://marketplace.visualstudio.com/items?itemName=avli.clojure