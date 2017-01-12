Deux manieres d'executer le projet :

1 - utiliser le script

Placez vous dans le repertoire du projet (DEV_TABR) ou se trouve les dossiers bin src et txt
Executez le fichier compile_execute
./compile_execute

N.B. : si le fichier ne s'execute pas, verifier les droits d'execution du script
solution : chmod 777 compile_execute

2 - compiler et executer manuellement

Sinon, placez vous dans le dossier du projet (DEV_TABR) (contenant les dossiers bin src et txt)
Compiler tous les fichiers .java a l'aide de la commande suivante
javac -d ./bin/ -cp ./bin/proj/ ./src/proj/*.java 

Placez vous ensuite dans le repertoire bin et executez la classe Application
cd bin
java proj.Application

