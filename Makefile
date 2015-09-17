# cibles qui ne sont pas des fichiers (évite conflit avec les éventuels fichiers de même nom)
.PHONY: clean, test, docs

# variables à redéfinir pour chaque applications
SOURCES= dungeon/*.java dungeon/room/*.java
TESTS= test/dungeon/*.java test/dungeon/room/*.java
# nom du fichier jar généré							
JAR_NAME= dungeon.jar 
# nom du manifeste utilisé pour création jar
MANIFEST= myManifest
# les packages utilisés
PACKAGES= dungeon dungeon.room
# les répertoires utilisés
DIR= dungeon dungeon/room
# le classpath à utiliser
CLASSPATH = .

# toutes les tâches
all: clean test docs jar 	

#structurer l'environnement de travail 
init:
	mkdir class
	mkdir test
	mkdir doc
	mkdir src

#compilation des sources	
compile: 
	cd src ; javac -classpath $(CLASSPATH) $(SOURCES) -d ../classes

#création du jar
jar:
	cd classes; jar cvfm ../$(JAR_NAME) ../$(MANIFEST) $(DIR)

#génération de la doc	
doc:
	cd src; javadoc $(PACKAGES) -d ../docs

#exécution par 'make args="val" run' si le jar exige des paramètres à l'exécution
run:
	java -jar $(JAR_NAME) ${args}

# génération des tests	
test: compile
	javac -classpath test-1.7.jar $(TESTS)

#exécution des tests en supposant les noms de classe de tests = XXXTest placées dans le dossier ./test/
%Test:
	java -jar test-1.7.jar $@

#nettoyage classes docs .jar et '.class' des tests
clean:
	rm -f -r classes; mkdir classes
	rm -f -r docs ; mkdir docs
	cd test ; find . -name *.class -delete
	find . -name *~ -delete
	rm -f $(JAR_NAME)
