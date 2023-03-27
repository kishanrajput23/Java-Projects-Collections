#!/bin/bash
#********************************************************
# Compilation code for the JNP Library project.
# To compile and deploy the library use the command
# >./build.sh -b
# This will build all the submodules and deploy them
# to MAVEN repository at Jefferson Lab
# To clean the previous build use:
# >./build.sh -c
# To clean all built jars and temporary files
# To generate JavaDoc ( Java API documentation) use:
# >./build.sh -d
#
# The project has a synchronized version set to all
# submodules, currently the change is done manually
# using the command:
# 
# mvn versions:set -DnewVersion=1.1-SNAPSHOT
# 
# this command is run in each directory, to switch the
# version numbers. In the future this will be automated
#--------------------------------------------------------
#********************************************************
#  Parsing command line arguments
#--------------------------------------------------------
while [ "$1" != "" ]; do
    case $1 in
	-c)
	    CLEAN_COMMAND="1"
	    shift 1
	    continue
	  ;;
	-b)
	    BUILD_COMMAND="1"
	    shift 1
	    continue
	  ;;
	-l)
	    LOCAL_BUILD_COMMAND="1"
	    shift 1
	    continue
	  ;;
	-d) 
	    DOCS_COMMAND="1"
	    shift 1
	    continue
	    ;;
        *) 
            break
    esac
done
#-----------------------------------------------------------
# If clean command was activated. maven clean is performed
# in all sub directories
#-----------------------------------------------------------
if [[ ! -z $CLEAN_COMMAND ]]
then
  echo 'Cleaning the distribution'
  cd jnp-utils  ; mvn clean; cd -
  cd jnp-cli   ; mvn clean; cd -
  cd jnp-hipo  ; mvn clean; cd -
  cd jnp-physics  ; mvn clean; cd -
  cd jnp-math  ; mvn clean; cd -
  cd jnp-distro ; rm -rf jaw* ; cd -
fi
#***********************************************************
# BUILD LOCALLY without deploying the distribution
#***********************************************************
if [[ ! -z $LOCAL_BUILD_COMMAND ]]
then
    echo 'building the distribution locally'
    rm -rf ~/.m2/repository/org/jlab/jnp
    cd jnp-utils ; mvn install; cd -
    cd jnp-cli   ; mvn install; cd -
    cd jnp-hipo  ; mvn install; cd -
    cd jnp-physics  ; mvn install; cd -
    cd jnp-math  ; mvn install; cd -
fi
#-----------------------------------------------------------
# If the build command is activated maven install and 
# maven deploy commands are executed for all sub modules
#-----------------------------------------------------------
if [[ ! -z $BUILD_COMMAND ]]
then
    echo 'building the distribution'
    rm -rf ~/.m2/repository/org/jlab/jnp
    cd jnp-utils ; mvn install; mvn deploy; cd -
    cd jnp-cli   ; mvn install; mvn deploy; cd -
    cd jnp-hipo  ; mvn install; mvn deploy; cd -
    cd jnp-math  ; mvn install; mvn deploy; cd -
    cd jnp-physics  ; mvn install; mvn deploy; cd -
fi
#-----------------------------------------------------------
# generating the documentation for the sub modules.
# if permissions permit, they will be ported to clas12
# documentation site.
#-----------------------------------------------------------
if [[ ! -z $DOCS_COMMAND ]]
then
  echo 'documenting the distribution'
  javadoc -d javadoc/groot -sourcepath src/main/java/ -subpackages org
  scp -r javadoc clas12@ifarm1402:/group/clas/www/clasweb/html/jhep/docs/.
fi

#-----------------------------------------------------------
echo ''; echo 'all done.....'; echo ''
