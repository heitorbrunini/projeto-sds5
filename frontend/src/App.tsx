import DataTable from "components/datatable";
import Footer from "components/footer";
import Navbar from "components/navbar";

function App() {
  return (
    <>
      <Navbar />
      <div className="container">
          <h1 className="text-primary">Hello World!</h1>
          <DataTable/>
      </div>      
      <Footer/>
    </>
  );
}

export default App;
