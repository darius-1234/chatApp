const ipcRenderer = require("electron").ipcRenderer;
mainWindow.loadFile(path.join(__dirname, '../public/index.html'));
require('electron-reload')(__dirname, {
    electron: path.join(__dirname, '../node_modules', '.bin', 'electron'),
    awaitWriteFinish: true,
});