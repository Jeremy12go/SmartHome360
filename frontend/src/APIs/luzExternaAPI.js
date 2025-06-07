import axios from 'axios';
const API_URL = 'http://localhost:8080/api';

export const registrarLE = (userId, dispositivo) => axios.post(`${API_URL}/usuarios/${userId}/luces/externa`, dispositivo);
export const obtenerLE = (userId) => axios.get(`${API_URL}/usuarios/${userId}/luces/externa`);
