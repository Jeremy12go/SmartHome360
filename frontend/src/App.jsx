import { Routes, Route } from 'react-router-dom';
import Lobby from './components/Lobby';
import ControlLuz from './components/luces/ControlLuz';

function App() {
    return (
        <Routes>
            <Route path="/" element={<Lobby />} />
            <Route path="/control/:usuarioId" element={<ControlLuz />} />
        </Routes>
    );
}

export default App
