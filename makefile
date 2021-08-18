#CSC2002S, 2021
#Matimba Maholobela
#Parallelism
#Assignment 1

JAVAC=/usr/bin/javac
.SUFFIXES: .java .class
SRCDIR=src
BINDIR=bin

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES= FileRead.class NormalRun.class ForkJoin.class ForkJoinRun.class 
         

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)
default: $(CLASS_FILES)
clean:
	rm $(BINDIR)/*.class

forkjoin:$(CLASS_FILES)
	java -cp bin ForkJoinRun

normal:$(CLASS_FILES)
	java -cp bin NormalRun

