import logo from './logo.svg';
import './App.css';
import ProductList from "./components/ProductList";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>My Shopping Platform</h1>
      </header>
      <main>
        <ProductList />
      </main>
    </div>
  );
}

export default App;
