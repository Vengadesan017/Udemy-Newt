# React
- Declarative
- Component-Based
- Virtual DOM
- in vs code after installin the node
  - extention
    - add ES7 extention
    - vscode react refactor
    - prettier
    - material
  - ternimal
    - node -V
    - npm -V
    - npx -V
    - npx create-react-app vv-app
    - npx create-react-app@5.0.1 vv-app
    - npm start
- download free template like mantis-free-react-admin-template from git hup or mui.com
  - npm install react-scripts -- save
  - npm install react@17 react-dom@17

- remove the unwanted files from template
- edit the package.json file
- implement AXIOS API
  - npm i axios@1.6.2
  - in client package
    - client.js
      - use axios to fetch data
- local server with backend and frontend file
  - backend vs code with java 17
    - localhost/swagger-ui/index.html
    - in v3/api-docs save the json
    - load that json file  by import
    - add the backened link to AXIOS api
    - solve COR error
      - add proxy in package.json
      - congif the controllser
- user management
- album use case
### react file structure
-  `<App />` -  "component rendering" or "component invocation"
```
my-react-app/
├── node_modules/          # Automatically generated; contains all the installed packages (dependencies)
├── public/                # Public files; assets and HTML template
│   ├── index.html         # The main HTML file; the entry point of the app
│   ├── favicon.ico        # The favicon for the app
│   └── manifest.json      # Web app manifest for Progressive Web Apps (PWA) settings
├── src/                   # Source code for the React app
│   ├── assets/            # (Optional) Folder for images, fonts, or other media assets
│   ├── components/        # Reusable UI components
│   │   ├── Header.js      # Example: Header component
│   │   ├── Footer.js      # Example: Footer component
│   │   └── Button.js      # Example: Button component
│   ├── App.js             # The main React component that renders the app UI
│   ├── index.js           # The entry point of the React app where ReactDOM renders the app
│   ├── App.css            # The main CSS styles for the app (optional, depends on setup)
│   ├── App.test.js        # Tests related to the App component (if using Jest)
│   └── serviceWorker.js   # Optional service worker for caching and offline support
├── .gitignore             # Specifies files and folders to be ignored by Git
├── package.json           # Lists project dependencies, scripts, and metadata
├── package-lock.json      # Contains exact versions of installed dependencies
├── README.md              # Project documentation and instructions
└── .env                   # Environment variables (optional)

```
