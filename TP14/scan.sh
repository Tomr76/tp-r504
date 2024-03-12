# Chemin vers le répertoire où vous souhaitez enregistrer les fichiers HTML
HTML_DIR="/home/user/tp-r504/TP14"

# Nom du fichier HTML
HTML_FILE="/home/user/tp-r504/TP14/vulnerability_report.html"

# Variables pour stocker le nombre de CVE et l'heure du scan
num_cve=0
scan_time=""

# Récupérer le nombre de CVE et l'heure du scan à partir du fichier journal
while IFS= read -r line; do
  if [[ $line == *"CVE"* ]]; then
    num_cve=$((num_cve + 1))
  elif [[ $line == *"Date et heure"* ]]; then
    scan_time=$(echo "$line" | awk -F ':' '{print $2}')
  fi
done < "/home/user/tp-r504/TP14/scan.log"

# Créer le contenu HTML
HTML_CONTENT="<html>
<head>
<title>Rapport des vulnérabilités</title>
</head>
<body>
<h2>Rapport des vulnérabilités</h2>
<p>Nombre de CVE : $num_cve</p>
<p>Heure du scan : $scan_time</p>
</body>
</html>"

# Enregistrer le contenu HTML dans un fichier
echo "$HTML_CONTENT" > "/home/user/tp-r504/TP14/vulnerability_report.html"

# Ouvrir le fichier HTML dans le navigateur par défaut
xdg-open "vulnerability_report.html"
