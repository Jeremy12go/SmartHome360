import { Routes, Route } from 'react-router-dom';
import Lobby from './pages/Lobby.jsx';
import Dispositivos from './pages/Dispositivos.jsx';

function App() {
    return (
        <Routes>
            <Route path="/" element={<Lobby />} />
            <Route path="/dispositivos/:usuarioId" element={<Dispositivos />} />
        </Routes>
    );
}

export default App
