# Resources

[Paradigms of Artificial Intelligence Programming (Norvig, 1991)](https://github.com/norvig/paip-lisp)

[Programming Clojure (Miller, 2018)](https://www.amazon.com/Programming-Clojure-Pragmatic-Programmers-Miller/dp/1680502468)

# Getting Started

- Visual Studio Code [recommended][blog]
- Install Java:
```
  brew install openjdk@11
  ls -l `which java`
  export JAVA_HOME=/usr/local/opt/openjdk@11
```

- [Install][Leiningen] Leiningen
- In [VS Code] 
  - add [extension](https://marketplace.visualstudio.com/items?itemName=avli.clojure) 
  - ``ctrl+` `` to emulate shell
  - `lein repl`


- Push to GitHub:
```
git remote set-url origin https://github.com/dpetz/clojure.git
git branch -M main
git push -u origin main
```

- Getting started with [syntax] and [repl] 

[Clojure]: https://clojure.org/
[syntax]: https://clojure.org/guides/learn/syntax
[repl]: https://clojure.org/guides/repl/basic_usage
[VS Code]: https://code.visualstudio.com/
[blog]: https://spin.atomicobject.com/2017/06/22/clojure-development-with-visual-studio-code/
[Leiningen]: https://leiningen.org/#install
[extension]: https://marketplace.visualstudio.com/items?itemName=avli.clojure