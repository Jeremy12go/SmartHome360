import axios from 'axios';
const API_URL = 'http://localhost:8080/api';

export const registrarAVE = (userId, dispositivo) => axios.post(`${API_URL}/usuarios/${userId}/asistentes/externa`, dispositivo);
export const obtenerAVE = (userId) => axios.get(`${API_URL}/usuarios/${userId}/asistentes/externa`);
