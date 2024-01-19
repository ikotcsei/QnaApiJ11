@REM ^ is the dont break line in winshit
@REM echo "how to print "

cd ./frontend && npm run build^
&& copy "E:\IdeaProjects\QnaApiJ11\frontend\dist\bundle.js" "E:\IdeaProjects\QnaApiJ11\src\main\resources\static\"^
&& copy "E:\IdeaProjects\QnaApiJ11\frontend\dist\index.html" "E:\IdeaProjects\QnaApiJ11\src\main\resources\templates\"^
&& cd .. && mvn package && cd "E:\IdeaProjects\QnaApiJ11\target" && java -jar QA.war

@REM copy "E:\IdeaProjects\QnaApiJ11\frontend\dist\bundle.js" "E:\IdeaProjects\QnaApiJ11\src\main\resources\static\"
@REM copy "E:\IdeaProjects\QnaApiJ11\frontend\dist\index.html" "E:\IdeaProjects\QnaApiJ11\src\main\resources\templates\"

@REM create package and compile if neccesary
@REM cd ..
@REM mvn package && cd "E:\IdeaProjects\QnaApiJ11\target" && java -jar QA.war

@REM run package for testing
