import axios from 'axios';
const API_URL = 'http://localhost:8080/api';

export const registrarL = (userId, dispositivo) => axios.post(`${API_URL}/usuarios/${userId}/luces`, dispositivo);
export const obtenerL = (userId) => axios.get(`${API_URL}/usuarios/${userId}/luces`);
