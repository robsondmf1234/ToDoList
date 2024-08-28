# Lista de Tarefas

Este é um aplicativo de lista de tarefas desenvolvido em Kotlin para Android. Ele utiliza o Android Jetpack, incluindo Navigation Component e Data Binding.

## Funcionalidades

- Adicionar, editar e remover tarefas
- Marcar tarefas como concluídas
- Navegação entre diferentes telas usando Navigation Component

## Estrutura do Projeto

- `app/src/main/java/com/example/listadetarefas/`: Contém as classes principais do aplicativo.
- `app/src/main/res/layout/`: Contém os arquivos de layout XML.
- `app/src/main/res/navigation/`: Contém os gráficos de navegação.

## Requisitos

- Android Studio Koala | 2024.1.1 Patch 2
- Gradle
- Kotlin

## Instalação

1. Clone o repositório:
    ```sh
    git clone https://github.com/seu-usuario/lista-de-tarefas.git
    ```
2. Abra o projeto no Android Studio.
3. Sincronize o projeto com Gradle.
4. Execute o aplicativo em um dispositivo ou emulador Android.

## Uso

1. Abra o aplicativo.
2. Adicione uma nova tarefa clicando no botão de adicionar.
3. Edite ou remova tarefas existentes clicando nelas.
4. Marque tarefas como concluídas clicando na caixa de seleção ao lado da tarefa.

## Contribuição

1. Faça um fork do projeto.
2. Crie uma nova branch:
    ```sh
    git checkout -b minha-nova-funcionalidade
    ```
3. Faça suas alterações e commit:
    ```sh
    git commit -m 'Adiciona nova funcionalidade'
    ```
4. Envie para o repositório remoto:
    ```sh
    git push origin minha-nova-funcionalidade
    ```
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

TODO:
- [x] Adicionar viewpager2 para exibir diversas listas de tarefas
- [x] Adicionado data store para a lista de tarefas
- [x] Adicionado Gson para serializar e deserializar objetos para converter em JSON a lista de tarefas para salvar no data store
- [x] Adicionado botão de adicionar tarefa
- [x] Adicionado fragmento de adicionar tarefa
- [ ] Ao clicar em concluido , adicionar esta tarefa a lista(dinamicList) de tarefas que esta na MainActivity 
- [ ] No metodo createFragment adicionar um logica para abrir o fragment de forma dinamica 
- [ ] Adicionar a biblioteca do Room
- [ ] Adicionar viewModel para o fragmento de adicionar tarefa
- [ ] Adicionar repository para gerenciar os dados
- [ ] Salvar dados localmente com Room
- [ ] Adicionar botão de navegação na toolbar
- [ ] Adicionar testes
- [ ] Adicionar testes
- [ ] Adicionar suporte a temas
- [ ] Adicionar suporte a idiomas
- [ ] Adicionar suporte a notificações
- 
```