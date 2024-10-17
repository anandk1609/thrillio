const fs = require('fs');
const path = require('path');
const directoryPath = './frmAddRecipient.sm';
const outputPath = './extracted_skins.txt';

function extractSkinValues() {
    fs.readdir(directoryPath, (err, files) => {
        if (err) {
            return console.log('Unable to scan directory: ' + err);
        }

        let uniqueSkinValues = new Set();
        let skinValues = [];

        files.forEach((file) => {
            const filePath = path.join(directoryPath, file);

            if (path.extname(file) === '.json') {
                const fileContent = fs.readFileSync(filePath, 'utf8');
                
                try {
                    const jsonData = JSON.parse(fileContent);

                    if (jsonData._skin_ && !uniqueSkinValues.has(jsonData._skin_)) {
                        uniqueSkinValues.add(jsonData._skin_);
                        skinValues.push(`${file} - ${jsonData._skin_}`);
                    }
                } catch (error) {
                    console.log(`Error parsing JSON file ${file}: `, error);
                }
            }
        });

        fs.writeFileSync(outputPath, skinValues.join('\n'), 'utf8');
        console.log('Skin values extracted and written to', outputPath);
    });
}

extractSkinValues();