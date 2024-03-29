const ipcRenderer = require("electron").ipcRenderer;

mainWindow.loadFile(path.join(__dirname, '../public/index.html'));
require('electron-reload')(__dirname, {
    electron: path.join(__dirname, '../node_modules', '.bin', 'electron'),
    awaitWriteFinish: true,
});

const { app, BrowserWindow, screen } = require('electron');

const createWindow = () => {
    const { width, height } = screen.getPrimaryDisplay().workAreaSize;

    window = new BrowserWindow({
        width: width / 1.25,
        height: height / 1.25,
        webPreferences: {
            nodeIntegration: true
        }
    });

    window.loadFile('public/index.html');
};

let window = null;

app.whenReady().then(createWindow)
app.on('window-all-closed', () => app.quit());