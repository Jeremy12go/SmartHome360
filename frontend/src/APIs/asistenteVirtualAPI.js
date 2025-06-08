import axios from 'axios';
const API_URL = 'http://localhost:8080/api';

export const registrarAV = (userId, dispositivo) => axios.post(`${API_URL}/usuarios/${userId}/asistentes`, dispositivo);
export const obtenerAV = (userId) => axios.get(`${API_URL}/usuarios/${userId}/asistentes`);
