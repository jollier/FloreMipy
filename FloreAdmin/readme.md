Pour lancer l'application avec un Run Configuration Maven Build entrer ces informations

Name :
FloreAdmin Run

Base directory :
${workspace_loc:/FloreAdmin}

Goals :
compile exec:java -Dexec.mainClass="com.floremipy.FloreAdminApplication" -Dspring.profiles.active="dev"
ou
compile exec:java -Dexec.mainClass="com.floremipy.FloreAdminApplication" -Dspring.profiles.active="prod"

si nécessaire, modifier les fichiers :
resources/com/floremipy/application-dev.properties
resources/com/floremipy/application-prod.properties