/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
  ],
  theme: {
    colors: {
      transparent: 'transparent',
      primary: {
        light: '#5eead4',
        DEFAULT: '#14b8a6',
        dark: '#0f766e',
      },
      secondary: {
        100: '#f6f7f8',
      },
      gray: '#f6f7f8',
      base2: '#ededed',
      white: '#ffffff',
      black: '#000000',
    },
  },
  plugins: [],
}

