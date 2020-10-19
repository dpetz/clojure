

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
```s
lein compile :all
```

Usefull `repl` commands:

[Good way][ns-repl] to call editor code in `repl`
```
(require '(paip [gps-test :as test] [gps :as gps]) :verbose :reload)
```
Rerun to compile saved changes.

Alternatively change namespace in `repl`:
```
(in-ns 'paip.gps-test)
(clojure.core/refer 'clojure.core)
(clojure.core/refer 'clojure.repl)
```
`use` is discouraged since _Clojure 1.4_


Run tests from `terminal:
```
lein test paip.gps-test
```
(autocompiles saved changes)

[ns-repl]: https://8thlight.com/blog/colin-jones/2010/12/05/clojure-libs-and-namespaces-require-use-import-and-ns.html
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