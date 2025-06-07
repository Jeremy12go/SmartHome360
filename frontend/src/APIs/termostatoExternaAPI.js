import axios from 'axios';
const API_URL = 'http://localhost:8080/api/termostatos/externa';

export const registrarTE = (dispositivo) => axios.post(API_URL, dispositivo);
export const obtenerTE = () => axios.get(API_URL);
