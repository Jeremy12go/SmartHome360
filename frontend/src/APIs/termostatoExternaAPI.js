import axios from 'axios';
const API_URL = 'http://localhost:8080/api';

export const registrarTE = (userId, dispositivo) => axios.post(`${API_URL}/usuarios/${userId}/termostatos/externa`, dispositivo);
export const obtenerTE = (userId) => axios.get(`${API_URL}/usuarios/${userId}/termostatos/externa`);