# Projeto Exercício 20/03 - Lista de Postagens 📱

Este repositório contém um projeto Android desenvolvido para fins de estudo, focado na criação de interfaces modernas com **Jetpack Compose** e organização de código seguindo o padrão **MVVM (Model-View-ViewModel)**.

## 🚀 Funcionalidades

- 📋 **Lista Dinâmica:** Exibição de posts consumindo dados estruturados em `Cards`.
- 🔎 **Filtro em Tempo Real:** Barra de busca funcional para filtrar a lista de posts instantaneamente.
- 🎯 **Interatividade:**
  - Clique no cartão para visualizar detalhes do post.
  - Botões de ação para remoção e criação de novos itens.
- 🧩 **Componentes Customizados:** Uso de `PostCard.kt` para reaproveitamento de interface.
- ✅ **Feedback Visual:** Implementação de `Checkboxes` e ícones de status para interação do usuário.

## 🛠 Tecnologias e Ferramentas

* **Linguagem:** [Kotlin](https://kotlinlang.org/)
* **UI:** [Jetpack Compose](https://developer.android.com/jetpack/compose) (Interface Declarativa)
* **Arquitetura:** MVVM (Separação entre Lógica e UI)
* **Gerenciamento de Estado:** `State` e `MutableState` com ViewModels.
* **IDE:** Android Studio Ladybug | 2024.2.2

---

## 📦 Estrutura de Pastas

A organização do código segue as melhores práticas para escalabilidade:

```text
com.example.Exercicio_2003
├── data          # Modelos de dados (Entity/Post)
├── ui
│   ├── components # Componentes (PostCard, etc.)
│   └── screens    # Telas (ListPostScreen, PostScreen)
├── viewmodels    # Lógica de negócio (PostViewModel)
└── MainActivity.kt
```

---

## 📝 Considerações Finais

Este projeto foi desenvolvido como um exercício prático para consolidar conhecimentos em Android Mobile Development.
Sinta-se à vontade para explorar o código e sugerir melhorias!

---

## 👨‍💻 Autor

**Jaciporan Vieira**
* 💼 Desenvolvedor FullStack
* ☁️ Experiência com Cloud e Java

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=flat&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/jaciporan-vieira-silva-483564158/)
[![Email](https://img.shields.io/badge/Email-D14836?style=flat&logo=gmail&logoColor=white)](mailto:jaciporan@email.com)
