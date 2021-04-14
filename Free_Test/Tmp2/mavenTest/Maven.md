# Java and Maven with VSCode

## Functions of Maven (What is Maven?)

* Building the Source Code
* Testing Source Code
* Packaging the Source Code into an Artifact (ZIP, JAR, WAR or EAR)
* Handles Versioning and Releases of the Artifacts
* Generating JavaDocs from the Source Code
* Managing Project Dependencies

## Basic environment Setting step-by-steps

1. Download latest Maven

    [Download Maven](https://downloads.apache.org/maven/maven-3/3.8.1/binaries/apache-maven-3.8.1-bin.zip) or [Maven Download Page](https://maven.apache.org/download.cgi?Preferred=ftp://ftp.osuosl.org/pub/apache/)

    After downloading, unzip the file, put it to a proper directory you like and remember the path of it!

2. Initialize Java

    1. Choose a version and install Java JDK
    2. Add Environment variable `JAVA_HOME` w.r.t. the path you unzip/store your JDK
    3. Add path `%JAVA_HOME%/bin`
    4. Check whether Java works use pwsh or cmd by typing `java --version` and `javac --version` (you should see the version msg prompts up)

3. Initialize Maven

    1. Add Environment variable `M2_HOME` w.r.t. the path you unzip/store your Maven
    2. Add path `%M2_HOME%/bin`
    3. Check whether Maven works use pwsh or cmd by typing `mvn --version` (you should see the version msg prompts up)

4. Set Java and Maven and Create a maven Project within VSCode

    1. Add extensions : `Java Extension Pack`, `Maven for Java`
    2. Create a Maven Java Project
       1. `F1 / ctrl+shift+P` --> Create a Java Project --> Maven --> maven-archetype-quickstart --> version 1.4 --> choose a directory of your Maven Project
       2. See the integrated terminal (Maven archetype) and wait for its initialization and prompting msg
       3. Set `Define value` properties then confirm your settings as...
            
            `groupId` : your association or group name
            
            `artifactId` : name of Maven project (default to be the same as `package`)
            
            `version` : (1.0-SNAPSHOT) default works fine
            
            `package` : directory name (default works fine)
       4. After than, you'll see the **BUILD SUCCESS** msg in terminal, then you can open the directory of your new project and start your work!

5. Config pom.xml
    1. To add Maven dependencies...

       **Method 1**
       
       go to [Maven Repo.](https://mvnrepository.com/)
       
       --> find what you need --> copy the code provided in the site
       
       --> paste it to your pom.xml inside the `<dependencies> </dependencies>` block (usually this is better for beginners since the diversity selections of the latter may confuse you a lot)

       **Method 2**
       
       See the explorer of "Java Project" and click **+** at RHS of "Maven Dependencies", search for what you need and select the proper one provided in vscode prompt

    2. Reset Java version
        
        ~~The default Java version is suck...~~
       1. Change tag `<properties>` and add tag `build` in the file "pom.xml", then change the <!-- JAVA_VERSION --> to the version you prefer
        
        ```xml
        <properties>
            <!-- some default properties... -->

            <!-- Add the following two lines -->
            <maven.compiler.source><!-- JAVA_VERSION --></maven.compiler.source>
            <maven.compiler.target><!-- JAVA_VERSION --></maven.compiler.target>
        </properties>

        <!-- you need to add Maven Toolchains Dependency -->
        <build>
            <pluginManagement>
                <plugins>
                    <plugin>
                        <artifactId>maven-compiler-plugin</artifactId>
                        <configuration>
                            <release><!-- JAVA_VERSION --></release>
                            <compilerArgs>
                                --enable-preview
                        </compilerArgs>
                        </configuration>
                    </plugin>
                    <plugin>
                        <artifactId>maven-surefire-plugin</artifactId>
                        <configuration>
                            <argLine>--enable-preview</argLine>
                        </configuration>
                    </plugin>
                    <plugin>
                        <artifactId>maven-failsafe-plugin</artifactId>
                        <configuration>
                            <argLine>--enable-preview</argLine>
                        </configuration>
                    </plugin>
                </plugins>
            </pluginManagement>

            <plugins>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-toolchains-plugin</artifactId>
                    <executions>
                    <execution>
                        <goals>
                            <goal>toolchain</goal>
                        </goals>
                        <configuration>
                            <toolchains>
                                <jdk>
                                    <version><!-- JAVA_VERSION --></version>
                                </jdk>
                            </toolchains>
                        </configuration>
                    </execution>
                    </executions>
                </plugin>
            </plugins>
        </build>
        ```

       2. Add a new file called "toolchains.xml" and paste the codes below, then change the <!-- JAVA_VERSION --> and <!-- JAVA_JDK_PATH -->
        
        ```xml
        <!-- in the file "toolchains.xml" -->
        <?xml version="1.0" encoding="UTF8"?>
        <toolchains>
            <toolchain>
                <type>jdk</type>
                <provides>
                    <version><!-- JAVA_VERSION --></version>
                </provides>
                <configuration>
                    <jdkHome><!-- JAVA_JDK_PATH --></jdkHome>
                </configuration>
            </toolchain>
        </toolchains>
        ```

        After changing, you'll see that `JRE System Library [JavaSE-XX]` in `JAVA PROJECT` (LHS bar) changes decently (XX --> your version).
        
        You can now write and run your code in your JDK version.

        In effect, you can add multiple Java version by simply duplicate the given code can do the same changes!