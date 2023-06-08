## Prova de conceito simples e didática de como rodar seus testes selenium no docker


1. Vai no site do docker, cria uma conta gratuita, baixa e instala o docker

2. Baixe a imagem docker que contem o selenium

   docker pull selenium/standalone-chrome

3. Verifique se a imagem foi realmente baixada

   docker images

4. Execute o container do docker
   docker run -d -p 4445:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome

5. Verifique se o container está rodando
   docker ps

6. Confira a versão que você está importando do Selenium  no seu build.gradle
 
Todas as versões disponíveis podem ser encontradas [no site oficial]( https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
)

7. Abra o docker e verifique os logs do Container

8. Abra o link do selenium grid (disponível no topo dentro do docker)

9. Checa os detalhes do broser dentro da UI do grid
  
` http://localhost:4445/ui

   {"browserName":"chrome",
   "browserVersion":"114.0",
   "platformName":"linux",
   "se:noVncPort":7900,
   "se:vncEnabled":true} `


10. Coloca exatamente o nome do browser, a versão e a plataforma no seu código java nas propriedades pra criar a conexão com o driver



OBS:
Como está usando o selenium dentro do docker, não precisa ter nenhum driver instalado na sua máquina


References
https://www.lambdatest.com/blog/run-selenium-tests-in-docker/
https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/remote/package-summary.html
https://github.com/razvanvancea/learnwithrv-youtube-projects/tree/master/selenium-java-docker-container-standalone
https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
https://www.selenium.dev/documentation/grid/
https://medium.com/@iamfaisalkhatri/parallel-execution-of-tests-using-selenium-grid-4-with-docker-compose-2dc243f4fe8b
