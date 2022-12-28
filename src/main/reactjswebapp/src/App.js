import './App.css';
import FormValidation from './components/FormValidation';
import GetCustomers from './components/GetCustomers';
import Navbar from './components/Navbar';


function App() {
  return (
    <div className="App">
      <Navbar />
      <GetCustomers />
      <FormValidation />
    </div>
  );
}

export default App;
