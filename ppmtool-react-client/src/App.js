import logo from './logo.svg';
import './App.css';
import Dashboard from './components/Dashboard';
import Header from './components/Header';
import 'bootstrap/dist/css/bootstrap.min.css'

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Header />
        <Dashboard />
      </header>
    </div>
  );
}

export default App;
