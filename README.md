[![Build Status](https://travis-ci.org/viniciuspires/reqlist.svg?branch=master)](https://travis-ci.org/viniciuspires/reqlist)
[![Coverage Status](https://coveralls.io/repos/viniciuspires/reqlist/badge.svg?branch=master)](https://coveralls.io/r/viniciuspires/reqlist?branch=master)

Reqlist
=======

Open Source Requirement Analysis for Agile Teams

Presentation
------------

The introductory slides are avaible at [this link on Google Docs (pt-BR)](https://docs.google.com/presentation/d/1qIGsYUuGXwlhsgofYy-TqHrHry7iWUKtXps71ZMUXYw/edit?usp=sharing).

Installation
-------------

To install, you just have to download the latest code and run in the root folder:

```console
mvn install
```

Then, choose your JavaEE application server (recommended: JBoss AS 7.1.1.Final) and create a Datasource with `DDL` and `DML` access, with a JNDI of `java:/ReqlistDS`.

After that, you can deploy it in your JavaEE application server and run it normally.

Contributing
------------

All documentation on this project is available at [this link on Google Docs (pt-BR)](https://docs.google.com/document/d/18yR9UUwc_QALzDXZmgp1XofucDZmyeKcO7oE5JdsKok/edit?usp=sharing).

The plans are to migrate the documentation to the Github Wiki and translating it to English. Any help is appreciated. Contact me if you want to contribute, or send a PR.
