[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.374 s
[INFO] Finished at: 2024-06-12T10:08:26-05:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.8.0:testCompile (default-testCompile) on project my-app: Compilation failure: Compilation failure:
[ERROR] /C:/Dev/PE/Training/Vitality-LLM-Copilot-ChatGPT-L&L/arch/my-app/src/test/java/com/mycompany/app/AppTest.java:[3,24] package org.junit does not exist     
[ERROR] /C:/Dev/PE/Training/Vitality-LLM-Copilot-ChatGPT-L&L/arch/my-app/src/test/java/com/mycompany/app/AppTest.java:[3,1] static import only from classes and interfaces
[ERROR] /C:/Dev/PE/Training/Vitality-LLM-Copilot-ChatGPT-L&L/arch/my-app/src/test/java/com/mycompany/app/AppTest.java:[5,17] package org.junit does not exist     
[ERROR] /C:/Dev/PE/Training/Vitality-LLM-Copilot-ChatGPT-L&L/arch/my-app/src/test/java/com/mycompany/app/AppTest.java:[15,6] cannot find symbol
[ERROR]   symbol:   class Test
[ERROR]   location: class com.mycompany.app.AppTest
[ERROR] /C:/Dev/PE/Training/Vitality-LLM-Copilot-ChatGPT-L&L/arch/my-app/src/test/java/com/mycompany/app/AppTest.java:[18,9] cannot find symbol
[ERROR]   symbol:   method assertTrue(boolean)
[ERROR]   location: class com.mycompany.app.AppTest
[ERROR] -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
0a$ 